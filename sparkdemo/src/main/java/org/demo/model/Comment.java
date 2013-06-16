package org.demo.model;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 10/06/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_text", nullable = false, length = 255)
    private String text;

    @Version
    private Long version;

    public Comment() {
        // no arg constructor
    }

    public Comment(String text) {
        Validate.notBlank("text must not be blank");
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        Validate.notBlank("text must not be blank");
        this.text = text;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
