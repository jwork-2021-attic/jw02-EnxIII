package S191220053.Task_two;

public enum Comparer{
    greater{
        @Override
        public boolean cmp(int a, int b){return (a > b);}
    },

    smaller{
        @Override
        public boolean cmp(int a, int b){return (a < b);}
    };

    public abstract boolean cmp(int a, int b);
}