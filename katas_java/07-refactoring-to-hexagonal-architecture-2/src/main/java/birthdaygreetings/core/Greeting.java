package birthdaygreetings.core;

class Greeting {
    private final String header;
    private final String content;

    private Greeting(String header, String content) {
        this.header = header;
        this.content = content;
    }

    static Greeting forBirthdayOf(Employee employee){
        String content = String.format("Happy Birthday, dear %s!", employee.firstName());
        String header = "Happy Birthday!";
        return new Greeting(header, content);
    }

    String header() {
        return header;
    }

    String content() {
        return content;
    }
}
