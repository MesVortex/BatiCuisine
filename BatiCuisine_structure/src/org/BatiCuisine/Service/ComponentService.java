package org.BatiCuisine.Service;

import org.BatiCuisine.Model.Component;
import org.BatiCuisine.Repository.Interfaces.ComponentRepository;

import java.util.List;
import java.util.UUID;

public class ComponentService {
    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public void addComponent(Component component) {
        componentRepository.addComponent(component);
    }

    public Component getComponentById(UUID componentID) {
        return componentRepository.getComponentById(componentID);
    }

    public List<Component> getAllComponents() {
        return componentRepository.getAllComponents();
    }

    public List<Component> getProjectComponents(UUID projectID){
        return componentRepository.getProjectComponents(projectID);
    }
}
