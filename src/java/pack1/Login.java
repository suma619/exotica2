/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hi
 */
@Entity
@Table(name = "LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByUserName", query = "SELECT l FROM Login l WHERE l.userName = :userName")
    , @NamedQuery(name = "Login.findByPass", query = "SELECT l FROM Login l WHERE l.pass = :pass")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "USER_NAME")
    private String userName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASS")
    private String pass;

    public Login() {
    }

    public Login(String pass) {
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pass != null ? pass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.pass == null && other.pass != null) || (this.pass != null && !this.pass.equals(other.pass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack1.Login[ pass=" + pass + " ]";
    }
    
}
