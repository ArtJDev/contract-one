
package com.company.contractone.view.contractconclusion;

import com.company.contractone.entity.ContractConclusion;

import com.company.contractone.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "contract-conclusions", layout = MainView.class)
@ViewController(id = "ctract_ContractConclusion.list")
@ViewDescriptor(path = "contract-conclusion-list-view.xml")
@LookupComponent("contractConclusionsDataGrid")
@DialogMode(width = "64em")
public class ContractConclusionListView extends StandardListView<ContractConclusion> {
}