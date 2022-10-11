<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="预紧固件牌号" prop="prefastenBrand">
      <el-input v-model="dataForm.prefastenBrand" placeholder="预紧固件牌号"></el-input>
    </el-form-item>
    <el-form-item label="预紧固件直径" prop="prefastenAperture">
      <el-input v-model="dataForm.prefastenAperture" placeholder="预紧固件直径"></el-input>
    </el-form-item>
    <el-form-item label="预紧固件长度" prop="prefastenLength">
      <el-input v-model="dataForm.prefastenLength" placeholder="预紧固件长度"></el-input>
    </el-form-item>
    <el-form-item label="钉库位置" prop="storehosePos">
      <el-input v-model="dataForm.storehosePos" placeholder="钉库位置"></el-input>
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
          prefastenBrand: '',
          prefastenAperture: '',
          prefastenLength: '',
          storehosePos: ''
        },
        dataRule: {
          prefastenBrand: [
            { required: true, message: '预紧固件牌号不能为空', trigger: 'blur' }
          ],
          prefastenAperture: [
            { required: true, message: '预紧固件直径不能为空', trigger: 'blur' }
          ],
          prefastenLength: [
            { required: true, message: '预紧固件长度不能为空', trigger: 'blur' }
          ],
          storehosePos: [
            { required: true, message: '钉库位置不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/processParametersJqrzk/fasten/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.prefastenBrand = data.fasten.prefastenBrand
                this.dataForm.prefastenAperture = data.fasten.prefastenAperture
                this.dataForm.prefastenLength = data.fasten.prefastenLength
                this.dataForm.storehosePos = data.fasten.storehosePos
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
              url: this.$http.adornUrl(`/processParametersJqrzk/fasten/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'prefastenBrand': this.dataForm.prefastenBrand,
                'prefastenAperture': this.dataForm.prefastenAperture,
                'prefastenLength': this.dataForm.prefastenLength,
                'storehosePos': this.dataForm.storehosePos
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
