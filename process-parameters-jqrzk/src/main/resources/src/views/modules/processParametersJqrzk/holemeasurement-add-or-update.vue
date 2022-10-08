<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="标准直径" prop="standardAperture">
      <el-input v-model="dataForm.standardAperture" placeholder="标准直径"></el-input>
    </el-form-item>
    <el-form-item label="初始电压值" prop="startVoltage">
      <el-input v-model="dataForm.startVoltage" placeholder="初始电压值"></el-input>
    </el-form-item>
    <el-form-item label="零点位置" prop="zeroPos">
      <el-input v-model="dataForm.zeroPos" placeholder="零点位置"></el-input>
    </el-form-item>
    <el-form-item label="测量深度" prop="measureDepth">
      <el-input v-model="dataForm.measureDepth" placeholder="测量深度"></el-input>
    </el-form-item>
    <el-form-item label="测量速度" prop="measureSpeed">
      <el-input v-model="dataForm.measureSpeed" placeholder="测量速度"></el-input>
    </el-form-item>
    <el-form-item label="测量提前量" prop="measureLead">
      <el-input v-model="dataForm.measureLead" placeholder="测量提前量"></el-input>
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
          standardAperture: '',
          startVoltage: '',
          zeroPos: '',
          measureDepth: '',
          measureSpeed: '',
          measureLead: ''
        },
        dataRule: {
          standardAperture: [
            { required: true, message: '标准直径不能为空', trigger: 'blur' }
          ],
          startVoltage: [
            { required: true, message: '初始电压值不能为空', trigger: 'blur' }
          ],
          zeroPos: [
            { required: true, message: '零点位置不能为空', trigger: 'blur' }
          ],
          measureDepth: [
            { required: true, message: '测量深度不能为空', trigger: 'blur' }
          ],
          measureSpeed: [
            { required: true, message: '测量速度不能为空', trigger: 'blur' }
          ],
          measureLead: [
            { required: true, message: '测量提前量不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/processParametersJqrzk/holemeasurement/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.standardAperture = data.holeMeasurement.standardAperture
                this.dataForm.startVoltage = data.holeMeasurement.startVoltage
                this.dataForm.zeroPos = data.holeMeasurement.zeroPos
                this.dataForm.measureDepth = data.holeMeasurement.measureDepth
                this.dataForm.measureSpeed = data.holeMeasurement.measureSpeed
                this.dataForm.measureLead = data.holeMeasurement.measureLead
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
              url: this.$http.adornUrl(`/processParametersJqrzk/holemeasurement/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'standardAperture': this.dataForm.standardAperture,
                'startVoltage': this.dataForm.startVoltage,
                'zeroPos': this.dataForm.zeroPos,
                'measureDepth': this.dataForm.measureDepth,
                'measureSpeed': this.dataForm.measureSpeed,
                'measureLead': this.dataForm.measureLead
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
