package com.entity.car;

/**
 * ��� ����������. ��������� ���������� ��������� �������� ��� ������������� �������� ������ ���
 * @author qny4i
 *
 */
public enum TYPE {
    /**
     * ���������
     * ������
     * ��������
     * ��������
     * �������������
     * �������������
     * ��������
     * ����������
     * �������
     * ������������
     * ������
     */
    PLATFORM(1), VAN(2), TANK(3), SUGGESTION(4), SORTEMENT(5), BOARD(6),
    CONTAINER(7), GASOLINE(8), TANKER(9), TENT(10), AVTOVOSCH(11), REFRIGERATOR(12), OTHERS(13);

    private Integer value;

    /**
     * Constructor.
     *
     * @param values
     *            ��������
     */
    TYPE(final Integer values) {
        this.value = values;
    }

    /**
     * A method for comparing String values with an ENUM element.
     *������������
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
