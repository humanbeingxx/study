package local.querydsl;

import org.apache.commons.lang3.tuple.Pair;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * @author : cuixiaoshuang@ktzh.lvwan.com
 * @date : 2019-02-21
 **/
@Entity
public class SpaceInfo implements Serializable {

    private static final long serialVersionUID = 7506589737141815513L;

    private Integer id;

    private String name;

    private Integer parentId;

    private String parentName;

    private List<List<List<Pair<Double, Double>>>> boundaryList;

    private String boundaryGeometryText;

    private Long area;

    private Integer level;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<List<List<Pair<Double, Double>>>> getBoundaryList() {
        return boundaryList;
    }

    public void setBoundaryList(List<List<List<Pair<Double, Double>>>> boundaryList) {
        this.boundaryList = boundaryList;
    }

    public String getBoundaryGeometryText() {
        return boundaryGeometryText;
    }

    public void setBoundaryGeometryText(String boundaryGeometryText) {
        this.boundaryGeometryText = boundaryGeometryText;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
