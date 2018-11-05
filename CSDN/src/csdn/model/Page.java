package csdn.model;
import java.util.List;

public class Page<T> {
    private Integer pageNo; // ��ǰҳ��
    public static final Integer SHOW_ITEMS = 4; // ÿҳ��ʾ������Ϣ
    private Integer countNo; // ���ݿ���һ���ж��ٷ��������ļ�¼
    private Integer totalPageNo; // һ���ж���ҳ��
    private List<T> list; // �Ѳ�ѯ�����ļ�¼���浽List������

    public Integer getPageNo() {
        // �����ǰҳ��С��1���򷵻�1
        if (pageNo < 1) {
            return 1;
        }

        // �����ǰҳ������ܵ�ҳ�룬�򷵻��ܵ�ҳ��
        if (pageNo > getTotalPageNo()) {
            // ����ܵ�ҳ�����0�����۸��ѯʱ��û�з�����������������򷵻�1
            if (0 == getTotalPageNo()) {
                return 1;
            }

            // �ܵ�ҳ�벻����0�������ܵ�ҳ��
            return getTotalPageNo();
        }

        // �����������������
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getCountNo() {
        return countNo;
    }

    public void setCountNo(Integer countNo) {
        this.countNo = countNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPageNo() {
        // ����ܵļ�¼���ܹ���ÿҳ��ʾ�������������ͷ��������Ľ��
        if (0 == getCountNo() % SHOW_ITEMS) {
            return getCountNo() / SHOW_ITEMS;
        }

        // ������ܱ����������ڳ��ԵĽ���� + 1
        return getCountNo() / SHOW_ITEMS + 1;
    }

}
