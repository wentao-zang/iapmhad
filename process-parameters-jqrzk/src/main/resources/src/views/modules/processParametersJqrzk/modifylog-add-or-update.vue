<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="日志类型" prop="logType">
      <el-input v-model="dataForm.logType" placeholder="日志类型"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="操作类型" prop="opType">
      <el-input v-model="dataForm.opType" placeholder="操作类型"></el-input>
    </el-form-item>
    <el-form-item label="操作内容" prop="opContent">
      <el-input v-model="dataForm.opContent" placeholder="操作内容"></el-input>
    </el-form-item>
    <el-form-item label="操作结果" prop="opResult">
      <el-input v-model="dataForm.opResult" placeholder="操作结果"></el-input>
    </el-form-item>
    <el-form-item label="操作时间" prop="logTime">
      <el-input v-model="dataForm.logTime" placeholder="操作时间"></el-input>
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
          logType: '',
          username: '',
          opType: '',
          opContent: '',
          opResult: '',
          logTime: ''
        },
        dataRule: {
          logType: [
            { required: true, message: '日志类型不能为空', trigger: 'blur' }
          ],
          username: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          opType: [
            { required: true, message: '操作类型不能为空', trigger: 'blur' }
          ],
          opContent: [
            { required: true, message: '操作内容不能为空', trigger: 'blur' }
          ],
          opResult: [
            { required: true, message: '操作结果不能为空', trigger: 'blur' }
          ],
          logTime: [
            { required: true, message: '操作时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/processParametersJqrzk/modifylog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.logType = data.modifyLog.logType
                this.dataForm.username = data.modifyLog.username
                this.dataForm.opType = data.modifyLog.opType
                this.dataForm.opContent = data.modifyLog.opContent
                this.dataForm.opResult = data.modifyLog.opResult
                this.dataForm.logTime = data.modifyLog.logTime
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
              url: this.$http.adornUrl(`/processParametersJqrzk/modifylog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'logType': this.dataForm.logType,
                'username': this.dataForm.username,
                'opType': this.dataForm.opType,
                'opContent': this.dataForm.opContent,
                'opResult': this.dataForm.opResult,
                'logTime': this.dataForm.logTime
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
