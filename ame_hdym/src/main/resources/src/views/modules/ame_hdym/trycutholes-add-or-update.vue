<template>
  <el-dialog
    :title="!dataForm.holeid ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="code">
      <el-input v-model="dataForm.code" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holerow">
      <el-input v-model="dataForm.holerow" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holecol">
      <el-input v-model="dataForm.holecol" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holex">
      <el-input v-model="dataForm.holex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holey">
      <el-input v-model="dataForm.holey" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holez">
      <el-input v-model="dataForm.holez" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holea">
      <el-input v-model="dataForm.holea" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holeb">
      <el-input v-model="dataForm.holeb" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="holec">
      <el-input v-model="dataForm.holec" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pholex">
      <el-input v-model="dataForm.pholex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pholey">
      <el-input v-model="dataForm.pholey" placeholder=""></el-input>
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
          holeid: 0,
          code: '',
          holerow: '',
          holecol: '',
          status: '',
          holex: '',
          holey: '',
          holez: '',
          holea: '',
          holeb: '',
          holec: '',
          pholex: '',
          pholey: '',
          time: ''
        },
        dataRule: {
          code: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holerow: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holecol: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holey: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holez: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holea: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holeb: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          holec: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pholex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pholey: [
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
        this.dataForm.holeid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.holeid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/trycutholes/info/${this.dataForm.holeid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.trycutholes.code
                this.dataForm.holerow = data.trycutholes.holerow
                this.dataForm.holecol = data.trycutholes.holecol
                this.dataForm.status = data.trycutholes.status
                this.dataForm.holex = data.trycutholes.holex
                this.dataForm.holey = data.trycutholes.holey
                this.dataForm.holez = data.trycutholes.holez
                this.dataForm.holea = data.trycutholes.holea
                this.dataForm.holeb = data.trycutholes.holeb
                this.dataForm.holec = data.trycutholes.holec
                this.dataForm.pholex = data.trycutholes.pholex
                this.dataForm.pholey = data.trycutholes.pholey
                this.dataForm.time = data.trycutholes.time
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
              url: this.$http.adornUrl(`/ame_hdym/trycutholes/${!this.dataForm.holeid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'holeid': this.dataForm.holeid || undefined,
                'code': this.dataForm.code,
                'holerow': this.dataForm.holerow,
                'holecol': this.dataForm.holecol,
                'status': this.dataForm.status,
                'holex': this.dataForm.holex,
                'holey': this.dataForm.holey,
                'holez': this.dataForm.holez,
                'holea': this.dataForm.holea,
                'holeb': this.dataForm.holeb,
                'holec': this.dataForm.holec,
                'pholex': this.dataForm.pholex,
                'pholey': this.dataForm.pholey,
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
