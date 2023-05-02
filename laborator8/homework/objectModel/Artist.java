package org.example.objectModel;
/*
@Entity
@Table(name = "artists")
@NamedQueries({
 @NamedQuery(name = "Artist.findAll",
 query = "select e from Artist e order by e.name"),
})
public class Artist implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
 @Column(name = "id")
 private Integer id;

 @Column(name = "name")
 private String name;
 //constructors, getters, setters, toString
 ...
}
 */
public class Artist {
    private int id;
    private String name;

    public Artist(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
