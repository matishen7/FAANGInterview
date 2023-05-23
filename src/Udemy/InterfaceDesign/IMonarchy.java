package Udemy.InterfaceDesign;

import java.util.List;

public interface IMonarchy {
    public void birth(String name, String parent);
    public void death(String name);
    public List<String> getOrderOfSuccession();
}
