package com.rop.event;

import java.util.concurrent.Executor;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;

public class SimpleRopEventMulticaster extends AbstractRopEventMulticaster {

	protected final Log logger = LogFactory.getLog(getClass());

	private Executor executor;

	public void multicastEvent(final RopEvent event) {
		try {
			for (final RopEventListener listener : getRopEventListeners(event)) {
				Executor executor = getExecutor();
				if (executor != null) {
					executor.execute(new Runnable() {

						public void run() {
							listener.onRopEvent(event);
						}
					});
				} else {
					listener.onRopEvent(event);
				}
			}
		} catch (Exception e) {
			logger.error("处理" + event.getClass().getName() + "事件发生异常", e);
		}
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
}
