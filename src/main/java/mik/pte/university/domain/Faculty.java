//package mik.pte.university.domain;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = false)
//@Entity(name=Client.TBL_NAME)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class Client extends AbstractEntity<Long> {
//    public static final String TBL_NAME="client";
//    public static final String FLD_NAME="name";
//    public static final String FLD_COUNTRY="country_id";
//
//    @Column(name=FLD_NAME,nullable=false)
//    @NotNull(message="Name cannot be empty")
//    @Size(min=2,max=50,message="Name length must be between 2 and 50")
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name=FLD_COUNTRY)
//    private Country country;
//
//}
