SELECT date_format(start_date,'%c') as Month,
CAR_ID, count(history_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where Month between 8 and 10
group by Month, CAR_ID
having  RECORDS>=5
order by month,car_id desc;