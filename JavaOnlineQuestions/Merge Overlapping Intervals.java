/**
 *INTER. BIT
 *QUE=> Given a collection of intervals, merge all overlapping intervals.
 *
 *	For example:
 *	Given [1,3],[2,6],[8,10],[15,18],
 *
 *	return [1,6],[8,10],[15,18].
 *
 *	Make sure the returned intervals are sorted.
 * 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * The solution below is the fastest solution
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start-b.start;
            }
        });
        ArrayList<Interval>res=new ArrayList<Interval>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<=end)
            {
                end=Math.max(intervals.get(i).end,end);
            }
            else
            {
                res.add(new Interval(start,end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }
        res.add(new Interval(start,end));
        
        return res;
    }
}
