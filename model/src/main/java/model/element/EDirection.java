package model.element;

public enum EDirection {
	TOP(0),
	RIGHT(1),
	BOTTOM(2),
	LEFT(3);
	
	private final int value;

    private EDirection(int value) {
        this.value = value;
    }
    
    public static EDirection valueToDirection(int value) {
        for (EDirection l : EDirection.values()) {
            if (l.value == value) {
            	return l;
            }
            	
        }
		return null;
    }
    
    public EDirection toLeft() {
    	if(getValue() == 0) {
    		return EDirection.valueToDirection(3);
    	}else {
    		return EDirection.valueToDirection(getValue() - 1);
    	}
    }
    
    public EDirection toRight() {
    	if(getValue() == 3) {
    		return EDirection.valueToDirection(0);
    	}else {
    		return EDirection.valueToDirection(getValue() + 1);
    	}
    }
    public int getValue() {
        return value;
    }
}
