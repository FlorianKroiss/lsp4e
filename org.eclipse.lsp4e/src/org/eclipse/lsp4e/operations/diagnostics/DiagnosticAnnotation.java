/*******************************************************************************
 * Copyright (c) 2019 Red Hat Inc. and others.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael Istria (Red Hat Inc.) - initial implementation
 *******************************************************************************/
package org.eclipse.lsp4e.operations.diagnostics;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.lsp4j.Diagnostic;

public class DiagnosticAnnotation extends Annotation {

	private final Diagnostic diagnostic;

	public DiagnosticAnnotation(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

	@Override
	public String getType() {
		return switch (diagnostic.getSeverity()) {
		case Error -> "org.eclipse.ui.workbench.texteditor.error"; //$NON-NLS-1$
		case Warning -> "org.eclipse.ui.workbench.texteditor.warning"; //$NON-NLS-1$
		case Information -> "org.eclipse.ui.workbench.texteditor.info"; //$NON-NLS-1$
		case Hint ->"org.eclipse.ui.workbench.texteditor.info"; //$NON-NLS-1$
		};
	}

	@Override
	public void setType(@Nullable String type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getText() {
		return this.diagnostic.getMessage();
	}

	@Override
	public void setText(@Nullable String text) {
		throw new UnsupportedOperationException();
	}

}
