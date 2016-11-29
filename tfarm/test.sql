select * from t_smallclassfy;
select * from t_bigclassfy;

select fsclass_id,fsclass_name,small.fbclass_id,small.create_time from t_smallclassfy small,t_bigclassfy big 
where small.fbclass_id=big.fbclass_id;


select fsclass_id,fsclass_name,small.fbclass_id,big.fbclass_name,small.create_time from t_smallclassfy small
left join t_bigclassfy big on small.fbclass_id=big.fbclass_id;