public class TuringTransition {

        private int action;
        private int nextstates;
        private char nextsymbol;
        public static final int LEFT=0,RIGHT=1,HALT=2;
        
        public TuringTransition(char n, int a, int ns){
                nextsymbol=n;
                nextstates=ns;
                @SuppressWarnings("unused")
				int action=a;
        }

        public int getStates() {
                return nextstates;
        }

        public void setStates(int nextstates) {
                this.nextstates = nextstates;
        }

        public char getSymbol() {
                return nextsymbol;
        }

        public void setSymbol(char nextsymbol) {
                this.nextsymbol = nextsymbol;
        }

        public int getAction() {
                return action;
        }

        public void setAction(int action) {
                this.action = action;
        }
        
        


}