package tn.itskills.android.todo.Utils.event;

/**
 * Created by adnenhamdouni on 07/03/2017.
 */

public class TodoEvent {

    public static class MyEvent {

        private String mAction;
        private int mPosition;

        public MyEvent() {
        }

        public MyEvent(String pAction, int pPosition) {
            mAction = pAction;
            mPosition = pPosition;
        }

        public String getAction() {
            return mAction;
        }

        public void setAction(String pAction) {
            mAction = pAction;
        }

        public int getPosition() {
            return mPosition;
        }

        public void setPosition(int pPosition) {
            mPosition = pPosition;
        }
    }
}
