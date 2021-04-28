import java.util.HashMap;
/**
���� ����� ������ ������� ���������, ����������� ��������� A* ��� ����������
���� �� �����. ��� ��������� �������� � ���� ��������� "�������� ������� �����" �
������ ��������� "�������� ������� �����".
����� ����, ���� ����� �������������
�������� ��������, ����������� ��������� ������ ���� A* ��� ���������� ���
���������.
 **/
public class AStarState
{
    /** ��� ������ �� �����, �� ������� ������������ �������� A*. **/
    private Map2D map;
    
   private  HashMap<Location, Waypoint> openWaypoint = new HashMap<>();
   private  HashMap<Location, Waypoint> closeWaypoint = new HashMap<>();

    /**
     ��������������� ����� ������ ��������� ��� ������������� ��������� ������ ���� A*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /**���������� �����, �� ������� ������������ ��������� A*. **/
    public Map2D getMap()
    {
        return map;
    }
    
    
    /** ���������� ������� ���������� �������� ������� �����.**/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
        return openWaypoint.size();
    }
    
    /**
     ���� ����� ��������� ��� �������� ������� ����� � ���������� ������� �����
� ������������ ������ ���������. ���� �������� ������� ����� ���, ���� �����
���������� <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
		if(openWaypoint.size()==0) return null;
		
		  Waypoint min;
		  Waypoint massWaypoin[] = new Waypoint[numOpenWaypoints()]; 
		  int i = 0;
			  
		  for(Waypoint a : openWaypoint.values()) 
		  { 
			  massWaypoin[i]=a; 
			  i++; 
		  }
		  
		  min=massWaypoin[0];
		  
		  for(i=1; i<numOpenWaypoints(); i++) 
		  {
			  if(massWaypoin[i].getTotalCost()<min.getTotalCost()) 
			  { 
				  min = massWaypoin[i];
			  } 
		  }
			
		  return min;
        // TODO:  Implement.
    }

    /**
     * ���� ����� ��������� ������� ����� � ��� ������������ (��� ������������ ��������� ��
     * �) ��������� "�������� ������� �����".  ���� ��� ��� ���������
     * ������� ����� � �������������� ����� ������� �����, �� ����� ������� ����� ������
     * ��������� � ���������.  ������ ���� ��������������� 
     * new waypoint ��� ���� ������� �����, �� ����� ������� ����� �������� ������ ������ <em>.
     * ����</em> �������� "���������� ���������" ����� ������� ����� ������ �������
     * �������� "���������� ���������" ������� �����.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
    	Waypoint a = openWaypoint.get(newWP.getLocation());
        if (a == null || newWP.getPreviousCost() < a.getPreviousCost())
        {
            openWaypoint.put(newWP.getLocation(), newWP);
            return true;
        }
        return false;
    }

    /**
    * ���������� true, ���� ��������� �������� ������� ����� �������� ������� �����
    * ��� ���������� ��������������.
         **/
        public boolean isLocationClosed(Location loc)
        {
            // TODO:  Implement.
        	if(closeWaypoint.containsKey(loc)) return true;
            return false;
        }
    
    /**
    * ���� ����� ���������� ������� ����� � ��������� ����� ��
��������� ������ � ��������.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    	closeWaypoint.put(loc,openWaypoint.get(loc));
    	openWaypoint.remove(loc);	
    }

 
}

