<template>
  <el-dialog
    :title="!dataForm.fixtureid ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="pointname">
      <el-input v-model="dataForm.pointname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryx">
      <el-input v-model="dataForm.theoryx" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryy">
      <el-input v-model="dataForm.theoryy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryz">
      <el-input v-model="dataForm.theoryz" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualx">
      <el-input v-model="dataForm.actualx" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualy">
      <el-input v-model="dataForm.actualy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualz">
      <el-input v-model="dataForm.actualz" placeholder=""></el-input>
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
          fixtureid: 0,
          pointname: '',
          theoryx: '',
          theoryy: '',
          theoryz: '',
          actualx: '',
          actualy: '',
          actualz: '',
          time: ''
        },
        dataRule: {
          pointname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryx: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualx: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualz: [
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
        this.dataForm.fixtureid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.fixtureid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/setstation/info/${this.dataForm.fixtureid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pointname = data.setstation.pointname
                this.dataForm.theoryx = data.setstation.theoryx
                this.dataForm.theoryy = data.setstation.theoryy
                this.dataForm.theoryz = data.setstation.theoryz
                this.dataForm.actualx = data.setstation.actualx
                this.dataForm.actualy = data.setstation.actualy
                this.dataForm.actualz = data.setstation.actualz
                this.dataForm.time = data.setstation.time
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
              url: this.$http.adornUrl(`/ame_hdym/setstation/${!this.dataForm.fixtureid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'fixtureid': this.dataForm.fixtureid || undefined,
                'pointname': this.dataForm.pointname,
                'theoryx': this.dataForm.theoryx,
                'theoryy': this.dataForm.theoryy,
                'theoryz': this.dataForm.theoryz,
                'actualx': this.dataForm.actualx,
                'actualy': this.dataForm.actualy,
                'actualz': this.dataForm.actualz,
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
