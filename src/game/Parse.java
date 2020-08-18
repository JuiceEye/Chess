package game;

public class Parse {
    private char start1;
    private int start2;
    private char end1;
    private int end2;
    private String transformation;


    public Parse(char start1, int start2, char end1, int end2) {
        if (start1 == 'a') {
            this.start1 = 1;
        }
        if (start1 == 'b') {
            this.start1 = 2;
        }
        if (start1 == 'c') {
            this.start1 = 3;
        }
        if (start1 == 'd') {
            this.start1 = 4;
        }
        if (start1 == 'e') {
            this.start1 = 5;
        }
        if (start1 == 'f') {
            this.start1 = 6;
        }
        if (start1 == 'g') {
            this.start1 = 7;
        }
        if (start1 == 'h') {
            this.start1 = 8;
        }

        if (end1 == 'a') {
            this.end1 = 1;
        }
        if (end1 == 'b') {
            this.end1 = 2;
        }
        if (end1 == 'c') {
            this.end1 = 3;
        }
        if (end1 == 'd') {
            this.end1 = 4;
        }
        if (end1 == 'e') {
            this.end1 = 5;
        }
        if (end1 == 'f') {
            this.end1 = 6;
        }
        if (end1 == 'g') {
            this.end1 = 7;
        }
        if (end1 == 'h') {
            this.end1 = 8;
        }
        this.start2 = start2;
        this.end2 = end2;
    }

    public Parse(char start1, int start2, char end1, int end2, String transformation) {
        if (start1 == 'a') {
            this.start1 = 1;
        }
        if (start1 == 'b') {
            this.start1 = 2;
        }
        if (start1 == 'c') {
            this.start1 = 3;
        }
        if (start1 == 'f') {
            this.start1 = 4;
        }
        if (start1 == 'e') {
            this.start1 = 5;
        }
        if (start1 == 'f') {
            this.start1 = 6;
        }
        if (start1 == 'g') {
            this.start1 = 7;
        }
        if (start1 == 'h') {
            this.start1 = 8;
        }

        if (end1 == 'a') {
            this.end1 = 1;
        }
        if (end1 == 'b') {
            this.end1 = 2;
        }
        if (end1 == 'c') {
            this.end1 = 3;
        }
        if (end1 == 'f') {
            this.end1 = 4;
        }
        if (end1 == 'e') {
            this.end1 = 5;
        }
        if (end1 == 'f') {
            this.end1 = 6;
        }
        if (end1 == 'g') {
            this.end1 = 7;
        }
        if (end1 == 'h') {
            this.end1 = 8;
        }
        this.start2 = start2;
        this.end2 = end2;
        this.transformation = transformation;
    }


    public char getStart1() {
        return start1;
    }

    public void setStart1(char start1) {
        this.start1 = start1;
    }

    public int getStart2() {
        return start2;
    }

    public void setStart2(int start2) {
        this.start2 = start2;
    }

    public char getEnd1() {
        return end1;
    }

    public void setEnd1(char end1) {
        this.end1 = end1;
    }

    public int getEnd2() {
        return end2;
    }

    public void setEnd2(int end2) {
        this.end2 = end2;
    }

    public String getTransformation() {
        return transformation;
    }

    public void setTransformation(String transformation) {
        this.transformation = transformation;
    }
}
