package lab.nice.demo.aop.model;

import java.sql.Timestamp;

public class Metrics {
    private Long id;
    private Long in;
    private Long out;
    private Timestamp time;

    public Metrics() {
        super();
    }

    public Metrics(Long id, Long in, Long out, Timestamp time) {
        this.id = id;
        this.in = in;
        this.out = out;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metrics metrics = (Metrics) o;

        if (id != null ? !id.equals(metrics.id) : metrics.id != null) return false;
        if (in != null ? !in.equals(metrics.in) : metrics.in != null) return false;
        if (out != null ? !out.equals(metrics.out) : metrics.out != null) return false;
        return time != null ? time.equals(metrics.time) : metrics.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (in != null ? in.hashCode() : 0);
        result = 31 * result + (out != null ? out.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "id=" + id +
                ", in=" + in +
                ", out=" + out +
                ", time=" + time +
                '}';
    }
}
