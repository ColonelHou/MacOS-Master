
```markdown
$ curl --compressed -H "Accept: application/json" -X   \
  GET "http://host.domain.com:8088/ws/v1/cluster/apps/application_1326821518301_0010"
  
  
$ curl --compressed -H "Accept: application/json" -X \
  GET "http://host.domain.com:8088/proxy/application_1326821518301_0010/ws/v1/mapreduce/jobs/job_1326821518301_10_10/tasks"
  
$ curl --compressed -X   \
  GET "http://host.domain.com:8088/proxy/application_1326821518301_0010/ws/v1/    \
  mapreduce/jobs/job_1326821518301_10_10/tasks/task_1326821518301_10_10_r_0/attempts"
```