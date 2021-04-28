
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/**
* ���� ����� �������� ���������������� ����������� Swing ��� ������������� ����� ������ ����� �
* 2D-�����. ������ ����� ��������� ��������� ����� ���������, �� ����� ��������
* ���������-��� ��, �������� �� ������ ���������� ��� ���.
*/
public class JMapCell extends JComponent
{
    private static final Dimension CELL_SIZE = new Dimension(12, 12);
    
    /** True ���������, ��� ������ �������� �������� ������, ���� ���������, ���� ��������. **/  
    boolean endpoint = false;
    
    
    /** True ��������, ��� ������ �������� ����������; false ��������, ��� ��� �� ���. **/
    boolean passable = true;
    
    //True ���������, ��� ��� ������ �������� ������ ���� ����� ������� � ������.
    boolean path = false;
    
    /**
    * ��������� ����� ������ ����� � �������� "�������������." ����
    * true ��������, ��� ������ �������� ����������.
    **/
    public JMapCell(boolean pass)
    {
    	// ���������� ���������������� ������ ������, ����� ��������� ��������� �������� ����.
        setPreferredSize(CELL_SIZE);
        
        setPassable(pass);
    }
    
    /** �������� ����� ������ �����, ������� �� ��������� �������� ����������. **/
    public JMapCell()
    {
    	// �������� ������ �����������, ������ true ��� "�����������".
        this(true);
    }
    
    /** �������� ��� ������ ��� ��������� ��� ��������. **/
    public void setEndpoint(boolean end)
    {
        endpoint = end;
        updateAppearance();
    }
    
    /**
    * ������������� ��� ������ ���������� ��� �� ����������. ���� �������� �����
    * ������ ��� ����������; ���� ������ ����� �� ��� �� ����������.
    **/
    public void setPassable(boolean pass)
    {
        passable = pass;
        updateAppearance();
    }
    
    /** ���������� true, ���� ��� ������ ���������, ��� false � ��������� ������. **/
    public boolean isPassable()
    {
        return passable;
    }
    
    /** ����������� ������� "����������" ��������� ������ �����. **/
    public void togglePassable()
    {
        setPassable(!isPassable());
    }
    
    /** �������� ��� ������ ��� ����� ����, ������������� ���������� A*. **/
    public void setPath(boolean path)
    {
        this.path = path;
        updateAppearance();
    }
    
    /**
    * ���� ��������������� ����� ��������� ���� ���� � ������������ � �������
    * ���������� ��������� ������.
    **/    
    private void updateAppearance()
    {
        if (passable)
        {
        	// ���������� ������. ������� ��� ��������� � ������� �������.
            setBackground(Color.WHITE);

            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        }
        else
        {
        	// ������������ ������. ������ ��� �������.  
            setBackground(Color.RED);
        }
    }

    /**
    * ���������� ������ paint ��� ��������� ����� ���� � ������
    * map.
    **/  
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
