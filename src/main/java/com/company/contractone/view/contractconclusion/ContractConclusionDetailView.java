package com.company.contractone.view.contractconclusion;

import com.company.contractone.entity.Contract;
import com.company.contractone.entity.ContractConclusion;
import com.company.contractone.entity.ContractType;
import com.company.contractone.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.combobox.EntityComboBox;
import io.jmix.flowui.component.combobox.JmixComboBox;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "contract-conclusions/:id", layout = MainView.class)
@ViewController(id = "ctract_ContractConclusion.detail")
@ViewDescriptor(path = "contract-conclusion-detail-view.xml")
@EditedEntityContainer("contractConclusionDc")
public class ContractConclusionDetailView extends StandardDetailView<ContractConclusion> {
    @ViewComponent
    private JmixSelect<ContractType> typeField;
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private JmixComboBox<Contract> base;
    @ViewComponent
    private JmixComboBox<ContractConclusion> parent;

    @Subscribe
    public void onInit(final InitEvent event) {
        typeField.setItems(List.of(ContractType.CONTRACT_CONCLUSION_PRJ, ContractType.CONTRACT_CONCLUSION_AGR));
        List<ContractConclusion> contractConclusions = dataManager.load(ContractConclusion.class).all().list();
        List<Contract> contracts = dataManager.load(Contract.class).all().list();
        base.setItems(contracts);
        parent.setItems(contractConclusions);
    }

    @Subscribe("parent")
    public void onParentComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixComboBox<ContractConclusion>, ContractConclusion> event) {
        getEditedEntity().setParentContractConclusion(event.getValue());
    }

    @Subscribe("base")
    public void onBaseComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixComboBox<Contract>, Contract> event) {
        getEditedEntity().setContract(event.getValue());
    }


}