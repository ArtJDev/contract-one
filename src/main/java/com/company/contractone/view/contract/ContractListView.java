
package com.company.contractone.view.contract;

import com.company.contractone.entity.Contract;

import com.company.contractone.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "contracts", layout = MainView.class)
@ViewController(id = "ctract_Contract.list")
@ViewDescriptor(path = "contract-list-view.xml")
@LookupComponent("contractsDataGrid")
@DialogMode(width = "64em")
public class ContractListView extends StandardListView<Contract> {
}