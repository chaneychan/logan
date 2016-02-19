package com.rop.event;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractRopEventMulticaster implements RopEventMulticaster {

	private Set<RopEventListener> ropEventListeners = new HashSet<RopEventListener>();

	private static final Map<Class<? extends RopEvent>, ListenerRegistry> cachedRopEventListeners = new HashMap<Class<? extends RopEvent>, ListenerRegistry>();

	public void removeAllRopListeners() {
		ropEventListeners.clear();
	}

	public void addRopListener(RopEventListener listener) {
		ropEventListeners.add(listener);
	}

	public void removeRopListener(RopEventListener listener) {
		ropEventListeners.remove(listener);
	}

	protected List<RopEventListener> getRopEventListeners(RopEvent event) {
		Class<? extends RopEvent> eventType = event.getClass();
		if (!cachedRopEventListeners.containsKey(eventType)) {
			LinkedList<RopEventListener> allListeners = new LinkedList<RopEventListener>();
			if (ropEventListeners != null && ropEventListeners.size() > 0) {
				for (RopEventListener ropEventListener : ropEventListeners) {
					if (supportsEvent(ropEventListener, eventType)) {
						allListeners.add(ropEventListener);
					}
				}
				sortRopEventListener(allListeners);
			}
			ListenerRegistry listenerRegistry = new ListenerRegistry(allListeners);
			cachedRopEventListeners.put(eventType, listenerRegistry);
		}
		return cachedRopEventListeners.get(eventType).getRopEventListeners();
	}

	protected boolean supportsEvent(RopEventListener listener, Class<? extends RopEvent> eventType) {
		SmartRopEventListener smartListener = (listener instanceof SmartRopEventListener ? (SmartRopEventListener) listener
				: new GenericRopEventAdapter(listener));
		return (smartListener.supportsEventType(eventType));
	}

	protected void sortRopEventListener(List<RopEventListener> ropEventListeners) {
		Collections.sort(ropEventListeners, new Comparator<RopEventListener>() {
			public int compare(RopEventListener o1, RopEventListener o2) {
				if (o1.getOrder() > o2.getOrder()) {
					return 1;
				} else if (o1.getOrder() < o2.getOrder()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	private class ListenerRegistry {

		public List<RopEventListener> ropEventListeners;

		private ListenerRegistry(List<RopEventListener> ropEventListeners) {
			this.ropEventListeners = ropEventListeners;
		}

		public List<RopEventListener> getRopEventListeners() {
			return ropEventListeners;
		}
	}
}
