package by.gsu.pms.enums;

interface Operable {

    int executeOperation(int op1, int op2);
}

public enum Operation implements Operable {

    MULTIPLY("multiplication") {
        @Override
        public int executeOperation(int op1, int op2) {
            return op1 * op2;
        }
    },
    ADD("adding") {
        @Override
        public int executeOperation(int op1, int op2) {
            return op1 + op2;
        }
    },
    SUBTRACT("subtracting") {
        @Override
        public int executeOperation(int op1, int op2) {
            return op1 - op2;
        }
    };

    private String name;

    public String getName(){
        return name;
    }

    Operation(String name){
        this.name = name;
    }

    public static Operation getByName(String name) {
        for (Operation operation: Operation.values()) {
            if(operation.name.equals(name)) {
                return operation;
            }
        }
        return null;
    }
}
