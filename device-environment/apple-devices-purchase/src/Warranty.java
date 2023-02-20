class Warranty {
    private int length; // length of warranty in months
    private String coverage; // type of coverage

    public Warranty(int length, String coverage) {
        this.length = length;
        this.coverage = coverage;
    }

    public int getLength() {
        return length;
    }

    public String getCoverage() {
        return coverage;
    }
}
