
package com.vairix.marveladapter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "available",
    "collectionURI",
    "items",
    "returned"
})
@Generated("jsonschema2pojo")
public class Stories {

    @JsonProperty("available")
    private Integer available;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<Item__2> items = new ArrayList<Item__2>();
    @JsonProperty("returned")
    private Integer returned;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("available")
    public Integer getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Stories withAvailable(Integer available) {
        this.available = available;
        return this;
    }

    @JsonProperty("collectionURI")
    public String getCollectionURI() {
        return collectionURI;
    }

    @JsonProperty("collectionURI")
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Stories withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    @JsonProperty("items")
    public List<Item__2> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item__2> items) {
        this.items = items;
    }

    public Stories withItems(List<Item__2> items) {
        this.items = items;
        return this;
    }

    @JsonProperty("returned")
    public Integer getReturned() {
        return returned;
    }

    @JsonProperty("returned")
    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public Stories withReturned(Integer returned) {
        this.returned = returned;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Stories withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stories.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("available");
        sb.append('=');
        sb.append(((this.available == null)?"<null>":this.available));
        sb.append(',');
        sb.append("collectionURI");
        sb.append('=');
        sb.append(((this.collectionURI == null)?"<null>":this.collectionURI));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        sb.append("returned");
        sb.append('=');
        sb.append(((this.returned == null)?"<null>":this.returned));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.available == null)? 0 :this.available.hashCode()));
        result = ((result* 31)+((this.collectionURI == null)? 0 :this.collectionURI.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.returned == null)? 0 :this.returned.hashCode()));
        result = ((result* 31)+((this.items == null)? 0 :this.items.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stories) == false) {
            return false;
        }
        Stories rhs = ((Stories) other);
        return ((((((this.available == rhs.available)||((this.available!= null)&&this.available.equals(rhs.available)))&&((this.collectionURI == rhs.collectionURI)||((this.collectionURI!= null)&&this.collectionURI.equals(rhs.collectionURI))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.returned == rhs.returned)||((this.returned!= null)&&this.returned.equals(rhs.returned))))&&((this.items == rhs.items)||((this.items!= null)&&this.items.equals(rhs.items))));
    }

}
