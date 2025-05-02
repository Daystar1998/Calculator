package utils.gbl;

import java.awt.GridBagConstraints;

/*
 * Enum to alias values for GridBagConstraints fill property
 */
public enum Fill {

	NONE(GridBagConstraints.NONE),
	HORIZONTAL(GridBagConstraints.HORIZONTAL),
	VERTICAL(GridBagConstraints.VERTICAL),
	BOTH(GridBagConstraints.BOTH);

	private int constraint;

	private Fill(int constraint) {

		this.constraint = constraint;
	}

	public int getConstraint() {

		return constraint;
	}
}
