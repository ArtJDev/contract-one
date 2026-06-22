
package com.company.contractone.view.contractconclusion;

import com.company.contractone.entity.ContractConclusion;

import com.company.contractone.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "contract-conclusions/:id", layout = MainView.class)
@ViewController(id = "ctract_ContractConclusion.detail")
@ViewDescriptor(path = "contract-conclusion-detail-view.xml")
@EditedEntityContainer("contractConclusionDc")
public class ContractConclusionDetailView extends StandardDetailView<ContractConclusion> {
}