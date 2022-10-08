<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="temp1">
      <el-input v-model="dataForm.temp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp2">
      <el-input v-model="dataForm.temp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp3">
      <el-input v-model="dataForm.temp3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp4">
      <el-input v-model="dataForm.temp4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp5">
      <el-input v-model="dataForm.temp5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp6">
      <el-input v-model="dataForm.temp6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tempx1">
      <el-input v-model="dataForm.tempx1" placeholder=""></el-input>
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
          temp1: '',
          temp2: '',
          temp3: '',
          temp4: '',
          temp5: '',
          temp6: '',
          tempx1: '',
          time: ''
        },
        dataRule: {
          temp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tempx1: [
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
              url: this.$http.adornUrl(`/ame_hdym/axistemp/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.temp1 = data.axistemp.temp1
                this.dataForm.temp2 = data.axistemp.temp2
                this.dataForm.temp3 = data.axistemp.temp3
                this.dataForm.temp4 = data.axistemp.temp4
                this.dataForm.temp5 = data.axistemp.temp5
                this.dataForm.temp6 = data.axistemp.temp6
                this.dataForm.tempx1 = data.axistemp.tempx1
                this.dataForm.time = data.axistemp.time
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
              url: this.$http.adornUrl(`/ame_hdym/axistemp/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'temp1': this.dataForm.temp1,
                'temp2': this.dataForm.temp2,
                'temp3': this.dataForm.temp3,
                'temp4': this.dataForm.temp4,
                'temp5': this.dataForm.temp5,
                'temp6': this.dataForm.temp6,
                'tempx1': this.dataForm.tempx1,
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
