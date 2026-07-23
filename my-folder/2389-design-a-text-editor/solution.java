class TextEditor {
    private StringBuilder left;
    private StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }
    
    public void addText(String text) {
        left.append(text);
    }
    
    public int deleteText(int k) {
        int actualDeleted = Math.min(k, left.length());
        left.setLength(left.length()-actualDeleted);
        return actualDeleted;
    }
    
    public String cursorLeft(int k) {
        int leftBound = Math.min(left.length(), k);
        for (int i = 0; i < leftBound; i++) {  
            int lastIdx = left.length()-1;
            right.append(left.charAt(lastIdx));
            left.deleteCharAt(lastIdx);
        }

        return left.substring(Math.max(0, left.length()-10), left.length());
    }
    
    public String cursorRight(int k) {
        int rightBound = Math.min(k, right.length());
        for (int i = 0; i < rightBound; i++) {  
            int lastIdx = right.length()-1;
            left.append(right.charAt(lastIdx));
            right.deleteCharAt(lastIdx);
        }

        return left.substring(Math.max(0, left.length()-10), left.length());
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
