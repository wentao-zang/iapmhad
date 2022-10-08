<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="Ѫ׼ֱ޶" prop="diameter">
      <el-input v-model="dataForm.diameter" placeholder="Ѫ׼ֱ޶"></el-input>
    </el-form-item>
    <el-form-item label="ӵʼէѹֵ" prop="orivol">
      <el-input v-model="dataForm.orivol" placeholder="ӵʼէѹֵ"></el-input>
    </el-form-item>
    <el-form-item label="cգλփ" prop="oripos">
      <el-input v-model="dataForm.oripos" placeholder="cգλփ"></el-input>
    </el-form-item>
    <el-form-item label="Ң̡ǰ" prop="advance">
      <el-input v-model="dataForm.advance" placeholder="Ң̡ǰ"></el-input>
    </el-form-item>
    <el-form-item label="Ңɮֈ" prop="deep">
      <el-input v-model="dataForm.deep" placeholder="Ңɮֈ"></el-input>
    </el-form-item>
    <el-form-item label="Ң˙ֈ" prop="vel">
      <el-input v-model="dataForm.vel" placeholder="Ң˙ֈ"></el-input>
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
          diameter: '',
          orivol: '',
          oripos: '',
          advance: '',
          deep: '',
          vel: ''
        },
        dataRule: {
          diameter: [
            { required: true, message: 'Ѫ׼ֱ޶不能为空', trigger: 'blur' }
          ],
          orivol: [
            { required: true, message: 'ӵʼէѹֵ不能为空', trigger: 'blur' }
          ],
          oripos: [
            { required: true, message: 'cգλփ不能为空', trigger: 'blur' }
          ],
          advance: [
            { required: true, message: 'Ң̡ǰ不能为空', trigger: 'blur' }
          ],
          deep: [
            { required: true, message: 'Ңɮֈ不能为空', trigger: 'blur' }
          ],
          vel: [
            { required: true, message: 'Ң˙ֈ不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ame_hdym/holediameas/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.diameter = data.holediameas.diameter
                this.dataForm.orivol = data.holediameas.orivol
                this.dataForm.oripos = data.holediameas.oripos
                this.dataForm.advance = data.holediameas.advance
                this.dataForm.deep = data.holediameas.deep
                this.dataForm.vel = data.holediameas.vel
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
              url: this.$http.adornUrl(`/ame_hdym/holediameas/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'diameter': this.dataForm.diameter,
                'orivol': this.dataForm.orivol,
                'oripos': this.dataForm.oripos,
                'advance': this.dataForm.advance,
                'deep': this.dataForm.deep,
                'vel': this.dataForm.vel
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
