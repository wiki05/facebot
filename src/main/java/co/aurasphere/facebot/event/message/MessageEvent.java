package co.aurasphere.facebot.event.message;

import co.aurasphere.facebot.event.EventCallbackHandler;
import co.aurasphere.facebot.event.base.BaseStringEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link EventCallbackHandler} that processes all the incoming callbacks
 * that contains a specific text message from Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public abstract class MessageEvent extends BaseStringEvent {

	/**
	 * @see BaseStringEvent#BaseEvent(String)
	 */
	public MessageEvent(String expectedMessage, boolean caseSensitive) {
		super(expectedMessage, caseSensitive);
	}

	/**
	 * @return true if the text message received by the callback equals the
	 *         expected message, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		if(!caseSensitive){
			expectedString = expectedString.toLowerCase();
			message = message.toLowerCase();
		}
		return message.equals(expectedString);
	}

}
