package com.company.contractone.view.contract;

import com.company.contractone.entity.Contract;
import com.company.contractone.entity.ContractConclusion;
import com.company.contractone.entity.ContractType;
import com.company.contractone.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.combobox.JmixComboBox;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "contracts/:id", layout = MainView.class)
@ViewController(id = "ctract_Contract.detail")
@ViewDescriptor(path = "contract-detail-view.xml")
@EditedEntityContainer("contractDc")
public class ContractDetailView extends StandardDetailView<Contract> {
    @ViewComponent
    private JmixSelect<ContractType> typeField;
    @ViewComponent
    private JmixComboBox<ContractConclusion> base;
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private JmixComboBox<Contract> parent;

    @Subscribe
    public void onInit(final InitEvent event) {
        typeField.setItems(List.of(ContractType.CONTRACT_PRJ, ContractType.CONTRACT_AGREEMENT));
        List<ContractConclusion> contractConclusions = dataManager.load(ContractConclusion.class).all().list();
        List<Contract> contracts = dataManager.load(Contract.class).all().list();
        base.setItems(contractConclusions);
        parent.setItems(contracts);
    }

    @Subscribe("base")
    public void onBaseComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixComboBox<ContractConclusion>, ContractConclusion> event) {
        getEditedEntity().setContractConclusion(event.getValue());
    }

    @Subscribe("parent")
    public void onParentComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixComboBox<Contract>, Contract> event) {
        getEditedEntity().setParentContract(event.getValue());
    }

}