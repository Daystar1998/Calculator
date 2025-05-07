package utils.gbl;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
 * Convenience class to simplify creating a GridBagConstraints object
 */
public class GBConstraints extends GridBagConstraints {

	private static final long serialVersionUID = 1L;

	public GBConstraints(int gridX, int gridY) {

		super();

		this.gridx = gridX;
		this.gridy = gridY;

		this.insets = new Insets(1, 2, 1, 2);
	}

	public GBConstraints size(int gridWidth, int gridHeight) {

		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;

		return this;
	}

	public GBConstraints width(int gridWidth) {

		this.gridwidth = gridWidth;

		return this;
	}

	public GBConstraints height(int gridHeight) {

		this.gridheight = gridHeight;

		return this;
	}

	public GBConstraints weight(int weightX, int weightY) {

		this.weightx = weightX;
		this.weighty = weightY;

		return this;
	}

	public GBConstraints weightX(int weightX) {

		this.weightx = weightX;

		return this;
	}

	public GBConstraints weightY(int weightY) {

		this.weighty = weightY;

		return this;
	}

	public GBConstraints insets(int length) {

		this.insets = new Insets(length, length, length, length);

		return this;
	}

	public GBConstraints insets(int top, int left, int bottom, int right) {

		this.insets = new Insets(top, left, bottom, right);

		return this;
	}

	public GBConstraints anchor(Anchor anchor) {

		this.anchor = anchor.getConstraint();

		return this;
	}

	public GBConstraints fill(Fill fill) {

		this.fill = fill.getConstraint();

		switch (fill) {

			case HORIZONTAL:
				weightx = 1;
				weighty = 0;
				break;
			case VERTICAL:
				weightx = 0;
				weighty = 1;
				break;
			case BOTH:
				weightx = 1;
				weighty = 1;
				break;
			default:
				weightx = 0;
				weighty = 0;
		}

		return this;
	}
}
