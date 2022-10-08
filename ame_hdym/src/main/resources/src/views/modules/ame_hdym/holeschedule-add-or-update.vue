<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="fixtureid">
      <el-input v-model="dataForm.fixtureid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="taskid">
      <el-input v-model="dataForm.taskid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holeokcounts">
      <el-input v-model="dataForm.holeokcounts" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holeSchedule">
      <el-input v-model="dataForm.holeSchedule" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holecounts">
      <el-input v-model="dataForm.holecounts" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          fixtureid: '',
          taskid: '',
          holeokcounts: '',
          holeSchedule: '',
          holecounts: '',
          time: ''
        },
        dataRule: {
          fixtureid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          taskid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holeokcounts: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holeSchedule: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holecounts: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/holeschedule/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fixtureid = data.holeschedule.fixtureid
                this.dataForm.taskid = data.holeschedule.taskid
                this.dataForm.holeokcounts = data.holeschedule.holeokcounts
                this.dataForm.holeSchedule = data.holeschedule.holeSchedule
                this.dataForm.holecounts = data.holeschedule.holecounts
                this.dataForm.time = data.holeschedule.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/holeschedule/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'fixtureid': this.dataForm.fixtureid,
                'taskid': this.dataForm.taskid,
                'holeokcounts': this.dataForm.holeokcounts,
                'holeSchedule': this.dataForm.holeSchedule,
                'holecounts': this.dataForm.holecounts,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
