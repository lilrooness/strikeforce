package strikeforce.observer;

import strikeforce.observer.events.SubjectEvent;

public interface Observer {

	public void notifyEvent(SubjectEvent event);
}
