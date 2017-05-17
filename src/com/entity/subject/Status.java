package com.entity.subject;

/**
 * ������������ ������������ ������ ������ ��� �����
 *
 * @author qny4ix
 *
 */
public enum Status {

    /**
     * ������, ��������, �������, � ���������, ������, ���������������
     *
     */

    OPEN(1), REJEJECTED(2), CANCELED(3), INPROGRESS(4), CLOSED(5), PROCESSED(6);

    private Integer value;

    /**
     * Constructor.
     *
     * @param values
     *            ��������
     */
    Status(final Integer values) {
        this.value = values;
    }

    /**
     * A method for comparing String values with an ENUM element. ������������
     *
     * @param name
     *            �������� String
     * @return True if matched, false if not matched
     */
    public boolean equalsTo(final Integer name) {
        return value.equals(name);
    }

    /**
     * A method to obtain a String from an ENUM element.
     *
     * @return �������� String
     */
    public Integer value() {
        return value;
    }
}
