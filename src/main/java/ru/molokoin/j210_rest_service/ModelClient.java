package ru.molokoin.j210_rest_service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "client")
@Table(name = "Clients", schema = "j200", catalog = "")
public class ModelClient implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "client_type", length = 100)
    private String client_type;
    @Column(name = "added", length = 100)
    private String added;
    // @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    // private Collection<ModelAddress> addresses = new ArrayList<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClient_type() {
        return client_type;
    }
    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }
    public String getAdded() {
        return added;
    }
    public void setAdded(String added) {
        this.added = added;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((client_type == null) ? 0 : client_type.hashCode());
        result = prime * result + ((added == null) ? 0 : added.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModelClient other = (ModelClient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (client_type == null) {
            if (other.client_type != null)
                return false;
        } else if (!client_type.equals(other.client_type))
            return false;
        if (added == null) {
            if (other.added != null)
                return false;
        } else if (!added.equals(other.added))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ModelClient [id=" + id + ", name=" + name + ", client_type=" + client_type + ", added=" + added + "]";
    }
    
    // @Transient
    // public Collection<ModelAddress> getAddresses() {
    //     return addresses;
    // }
    // public void setAddresses(Collection<ModelAddress> addresses) {
    //     this.addresses = addresses;
    // }
}
