package utils.gbl;

import java.awt.GridBagConstraints;

/*
 * Enum to alias values for GridBagConstraints anchor property
 */
public enum Anchor {

	CENTER(GridBagConstraints.CENTER),
	NORTH(GridBagConstraints.NORTH),
	SOUTH(GridBagConstraints.SOUTH),
	EAST(GridBagConstraints.EAST),
	WEST(GridBagConstraints.WEST),
	NORTHWEST(GridBagConstraints.NORTHWEST),
	NORTHEAST(GridBagConstraints.NORTHEAST),
	SOUTHEAST(GridBagConstraints.SOUTHEAST),
	SOUTHWEST(GridBagConstraints.SOUTHWEST),
	// Top
	PAGE_START(GridBagConstraints.PAGE_START),
	// Bottom
	PAGE_END(GridBagConstraints.PAGE_END),
	// Left
	LINE_START(GridBagConstraints.LINE_START),
	// Right
	LINE_END(GridBagConstraints.LINE_END),
	// Top left
	FIRST_LINE_START(GridBagConstraints.FIRST_LINE_START),
	// Top right
	FIRST_LINE_END(GridBagConstraints.FIRST_LINE_END),
	// Bottom left
	LAST_LINE_START(GridBagConstraints.LAST_LINE_START),
	// Bottom right
	LAST_LINE_END(GridBagConstraints.LAST_LINE_END);

	private int constraint;

	private Anchor(int constraint) {

		this.constraint = constraint;
	}

	public int getConstraint() {

		return constraint;
	}
}
