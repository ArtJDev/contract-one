
package com.company.contractone.view.contract;

import com.company.contractone.entity.Contract;

import com.company.contractone.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "contracts/:id", layout = MainView.class)
@ViewController(id = "ctract_Contract.detail")
@ViewDescriptor(path = "contract-detail-view.xml")
@EditedEntityContainer("contractDc")
public class ContractDetailView extends StandardDetailView<Contract> {
}