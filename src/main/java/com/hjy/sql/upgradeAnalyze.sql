INSERT IGNORE student_info
SELECT temp.student_num,temp.name,temp.password,temp.sex,temp.class_num,temp.class_name,temp.nation_id,major.major_id,temp.city_id,null FROM
(
SELECT
	ods_data.student_num,ods_data.name,'12345678' password,ods_data.sex,ods_data.class_num,ods_data.class_name, ods_data.nation_id,
 	SUBSTR(filter_num(class_name) FROM 3 FOR LENGTH(filter_num(class_name))) major_,
    #filter_num(class_name) major_,
	round(rand()*(360-1)+1) city_id
FROM ods_data
) temp
LEFT JOIN
major
ON  temp.major_=major.major_name;

INSERT IGNORE test_score
SELECT null,temp.student_num,temp.height,temp.weight,temp.hw_score,temp.hw_rank,temp.vitual_capacity,temp.vc_score,temp.vc_rank,temp.s_50m ,
				temp.s_50m_score,temp.s_50m_rank,temp.long_jump,temp.lj_score,temp.lj_rank,
				temp.sit_and_reach,temp.sar_score,temp.sar_rank,temp.s_800m,temp.s_800m_score,temp.s_800m_rank,temp.s_1000m,temp.s_1000m_score,temp.s_1000m_rank,temp.sit_up,
				temp.su_score,temp.su_rank,temp.pull_up,temp.pu_score,temp.pu_rank,
				temp.standard_score,temp.add_score,temp.total_score,temp.total_rank,temp.grade,date,sex
FROM
(
SELECT student_num,height,weight,hw_score,hw_rank,vitual_capacity,vc_score,vc_rank,s_50m ,s_50m_score,s_50m_rank,long_jump,lj_score,lj_rank,
				sit_and_reach,sar_score,sar_rank,s_800m,s_800m_score,s_800m_rank,s_1000m,s_1000m_score,s_1000m_rank,sit_up,su_score,su_rank,pull_up,pu_score,pu_rank,
				standard_score,add_score,total_score,total_rank,grade,date,sex
FROM ods_data
) temp
;
truncate table suggestion;
INSERT INTO suggestion
SELECT NULL,CONCAT_WS(',',hw_sug,vc_sug,s_50_sug,sar_sug, lj_score,sit_up_or_pull_up_sug,long_run),'课程建议',test_score_id
FROM
(
SELECT
test_score_id,
(CASE
WHEN hw_score<60 THEN (SELECT id from suggestion_classify WHERE item='BMI' and item_rank = '一级')
WHEN hw_score<80 THEN (SELECT id from suggestion_classify WHERE item='BMI' and item_rank = '二级')
WHEN hw_score<90 THEN (SELECT id from suggestion_classify WHERE item='BMI' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='BMI' and item_rank = '四级')
END
) hw_sug,
(CASE
WHEN vc_score>=90 THEN (SELECT id from suggestion_classify WHERE item='vitual_capacity' and item_rank = '一级')
WHEN vc_score>=72 THEN (SELECT id from suggestion_classify WHERE item='vitual_capacity' and item_rank = '二级')
WHEN vc_score>=60 THEN (SELECT id from suggestion_classify WHERE item='vitual_capacity' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='vitual_capacity' and item_rank = '四级')
END
) vc_sug,
(CASE
WHEN s_50m_score>=90 THEN (SELECT id from suggestion_classify WHERE item='s_50m' and item_rank = '一级')
WHEN s_50m_score>=80 THEN (SELECT id from suggestion_classify WHERE item='s_50m' and item_rank = '二级')
WHEN s_50m_score>=60 THEN (SELECT id from suggestion_classify WHERE item='s_50m' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='s_50m' and item_rank = '四级')
END
) s_50_sug,
(CASE
WHEN sar_score>=90 THEN (SELECT id from suggestion_classify WHERE item='sit_and_reach' and item_rank = '一级')
WHEN sar_score>=70 THEN (SELECT id from suggestion_classify WHERE item='sit_and_reach' and item_rank = '二级')
WHEN sar_score>=60 THEN (SELECT id from suggestion_classify WHERE item='sit_and_reach' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='sit_and_reach' and item_rank = '四级')
END
) sar_sug,
(CASE
WHEN lj_score>=85 THEN (SELECT id from suggestion_classify WHERE item='long_jump' and item_rank = '一级')
WHEN lj_score>=72 THEN (SELECT id from suggestion_classify WHERE item='long_jump' and item_rank = '二级')
WHEN lj_score>=60 THEN (SELECT id from suggestion_classify WHERE item='long_jump' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='long_jump' and item_rank = '四级')
END
) lj_score,
(
CASE
WHEN gender=1 THEN
(CASE
WHEN pu_score>=80 THEN (SELECT id from suggestion_classify WHERE item='pull_up' and item_rank = '一级')
WHEN pu_score>=68 THEN (SELECT id from suggestion_classify WHERE item='pull_up' and item_rank = '二级')
WHEN pu_score>=50 THEN (SELECT id from suggestion_classify WHERE item='pull_up' and item_rank = '三级')
WHEN pu_score>=10 THEN (SELECT id from suggestion_classify WHERE item='pull_up' and item_rank = '四级')
ELSE (SELECT id from suggestion_classify WHERE item='pull_up' and item_rank = '五级')
END
)
ELSE
(CASE
WHEN su_score>=90 THEN (SELECT id from suggestion_classify WHERE item='sit_up' and item_rank = '一级')
WHEN su_score>=74 THEN (SELECT id from suggestion_classify WHERE item='sit_up' and item_rank = '二级')
WHEN su_score>=60 THEN (SELECT id from suggestion_classify WHERE item='sit_up' and item_rank = '三级')
WHEN su_score>=10 THEN (SELECT id from suggestion_classify WHERE item='sit_up' and item_rank = '四级')
ELSE (SELECT id from suggestion_classify WHERE item='sit_up' and item_rank = '五级')
END
)
END
) sit_up_or_pull_up_sug,
(CASE
WHEN gender=1 THEN(
CASE
WHEN s_1000m_score>=85 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '一级')
WHEN s_1000m_score>=70 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '二级')
WHEN s_1000m_score>=40 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '四级')
END
)
ELSE(
CASE
WHEN s_800m_score>=85 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '一级')
WHEN s_800m_score>=70 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '二级')
WHEN s_800m_score>=40 THEN (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '三级')
ELSE (SELECT id from suggestion_classify WHERE item='long_run' and item_rank = '四级')
END
)
END
)
long_run

FROM test_score
) teacher_suggestion;

truncate table ads_region;
insert into ads_region
select null,city_id,rank() over (order by amount desc) region_rank,amount,grade
from(
           select city_id,count(*) amount, ts.grade
           from test_score ts
                    left join student_info si on ts.student_id = si.school_number
           where ts.grade = 41
           group by si.city_id
) temp
order by amount desc
limit 10;
insert into ads_region
select null,city_id,rank() over (order by amount desc) region_rank,amount,grade
from(
           select city_id,count(*) amount, ts.grade
           from test_score ts
                    left join student_info si on ts.student_id = si.school_number
           where ts.grade = 42
           group by si.city_id
) temp
order by amount desc
limit 10;
insert into ads_region
select null,city_id,rank() over (order by amount desc) region_rank,amount,grade
from(
           select city_id,count(*) amount, ts.grade
           from test_score ts
                    left join student_info si on ts.student_id = si.school_number
           where ts.grade = 43
           group by si.city_id
) temp
order by amount desc
limit 10;
insert into ads_region
select null,city_id,rank() over (order by amount desc) region_rank,amount,grade
from(
           select city_id,count(*) amount, ts.grade
           from test_score ts
                    left join student_info si on ts.student_id = si.school_number
           where ts.grade = 44
           group by si.city_id
) temp
order by amount desc
limit 10;


truncate table ads_testscore;
insert into ads_testscore
select null,'bmi' item,gender sex,grade,max(hw_score) best_score,count(*) amount
from test_score
where hw_score>60
group by grade,gender;


insert into ads_testscore
select null, 'vitual_capacity' item,gender sex,grade,max(vitual_capacity) best_score,count(*) amount
from test_score
where vc_score>60
group by grade,gender;

insert into ads_testscore
select null, 's_50m' item,gender sex,grade,min(s_50m) best_score,count(*) amount
from test_score
where s_50m_score>60
group by grade,gender;

insert into ads_testscore
select null,'long_jump' item,gender sex,grade,max(long_jump) best_score,count(*) amount
from test_score
where lj_score>60
group by grade,gender;


insert into ads_testscore
select null, 'sit_and_reach' item,gender sex,grade,max(sit_and_reach) best_score,count(*) amount
from test_score
where sar_score>60
group by grade,gender;


insert into ads_testscore
select null,'sit_and_reach' item,gender sex,grade,max(sit_and_reach) best_score,count(*) amount
from test_score
where sar_score>60
group by grade,gender;


insert into ads_testscore
select null,
        's_800m' item,2 sex,grade,
       concat_ws('′',floor(min(convert(substring(s_800m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_800m,3,3),unsigned integer))/100),
           min(convert(substring(s_800m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_800m,3,3),unsigned integer))-100*floor(min(convert(substring(s_800m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_800m,3,3),unsigned integer))/100)
           ) best_score,
       count(*) amount
from test_score
where s_800m_score>60 and gender=2
group by grade;


insert into ads_testscore
select null,
        's_1000m' item,1 sex,grade,
       concat_ws('′',floor(min(convert(substring(s_1000m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_1000m,3,3),unsigned integer))/100),
           min(convert(substring(s_1000m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_1000m,3,3),unsigned integer))-100*floor(min(convert(substring(s_1000m,1,1),UNSIGNED INTEGER)*100+convert(substring(s_1000m,3,3),unsigned integer))/100)
           ) best_score,
       count(*) amount
from test_score
where s_1000m_score>60 and gender=1
group by grade;


insert into ads_testscore
select null,'sit_up' item,gender sex,grade,max(sit_up) best_score,count(*) amount
from test_score
where su_score>60 and gender=2
group by grade;

insert into ads_testscore
select null, 'pull_up' item,gender sex,grade,max(pull_up) best_score,count(*) amount
from test_score
where pu_score>60 and gender=1
group by grade;

insert into ads_testscore
select null, 'total' item,gender sex,grade,max(total_score),count(*) amount
from test_score
where total_score>60
group by grade,gender;


truncate table ads_passraterank;
insert into ads_passraterank
select null,'total',sum(if(total_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;

insert into ads_passraterank
select null,'bmi',sum(if(hw_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;

insert into ads_passraterank
select null,'vitual_capacity',sum(if(vc_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;



insert into ads_passraterank
select null,'s_50m',sum(if(s_50m_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;


insert into ads_passraterank
select null,'long_jump',sum(if(lj_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;

insert into ads_passraterank
select null,'sit_and_reach',sum(if(sar_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
group by si.major_id;

insert into ads_passraterank
select null,'s_800m',sum(if(s_800m_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
    where gender=2
group by si.major_id;

insert into ads_passraterank
select null,'s_1000m',sum(if(s_1000m_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
    where gender=1
group by si.major_id;


insert into ads_passraterank
select null,'sit_up',sum(if(su_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
    where gender=2
group by si.major_id;



insert into ads_passraterank
select null,'pull_up',sum(if(pu_score>60,1,0))/count(*) passrank,major_id
from test_score ts
left join student_info si
on si.school_number = ts.student_id
    where gender=1
group by si.major_id;
truncate table ods_data;