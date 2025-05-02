package utils.gbl;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
 * Convenience class to simplify creating a GridBagConstraints object
 */
public class GBConstraints extends GridBagConstraints {

	private static final long serialVersionUID = 1L;

	public GBConstraints(int gridX, int gridY) {

		this(gridX, gridY, Fill.NONE);
	}

	public GBConstraints(int gridX, int gridY, Fill fill) {

		this(gridX, gridY, 1, 1, fill);
	}

	public GBConstraints(int gridX, int gridY, int gridWidth, int gridHeight) {

		this(gridX, gridY, gridWidth, gridHeight, Fill.NONE);
	}

	public GBConstraints(int gridX, int gridY, int gridWidth, int gridHeight, Fill fill) {

		super();

		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
		this.setFill(fill);

		this.insets = new Insets(1, 2, 1, 2);
	}

	public GBConstraints setSize(int gridWidth, int gridHeight) {

		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;

		return this;
	}

	public GBConstraints setWidth(int gridWidth) {

		this.gridwidth = gridWidth;

		return this;
	}

	public GBConstraints setHeight(int gridHeight) {

		this.gridheight = gridHeight;

		return this;
	}

	public GBConstraints setWeight(int weightX, int weightY) {

		this.weightx = weightX;
		this.weighty = weightY;

		return this;
	}

	public GBConstraints setWeightX(int weightX) {

		this.weightx = weightX;

		return this;
	}

	public GBConstraints setWeightY(int weightY) {

		this.weighty = weightY;

		return this;
	}

	public GBConstraints setInsets(int length) {

		this.insets = new Insets(length, length, length, length);

		return this;
	}

	public GBConstraints setInsets(int top, int left, int bottom, int right) {

		this.insets = new Insets(top, left, bottom, right);

		return this;
	}

	public GBConstraints setAnchor(Anchor anchor) {

		this.anchor = anchor.getConstraint();

		return this;
	}

	public GBConstraints setFill(Fill fill) {

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
