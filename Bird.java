class Bird {
    private String name;
    private int count;

    public Bird(String name) {
        this.name = name;
        this.count = 1;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count += 1;
    }
}
