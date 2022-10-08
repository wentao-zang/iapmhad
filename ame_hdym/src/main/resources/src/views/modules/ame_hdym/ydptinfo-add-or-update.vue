<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="λփ" prop="pos">
      <el-input v-model="dataForm.pos" placeholder="λփ"></el-input>
    </el-form-item>
    <el-form-item label="˙ֈ" prop="vel">
      <el-input v-model="dataForm.vel" placeholder="˙ֈ"></el-input>
    </el-form-item>
    <el-form-item label="ܓ˙ֈ" prop="ac">
      <el-input v-model="dataForm.ac" placeholder="ܓ˙ֈ"></el-input>
    </el-form-item>
    <el-form-item label="էۺת˙" prop="rotvel">
      <el-input v-model="dataForm.rotvel" placeholder="էۺת˙"></el-input>
    </el-form-item>
    <el-form-item label="էw" prop="current">
      <el-input v-model="dataForm.current" placeholder="էw"></el-input>
    </el-form-item>
    <el-form-item label="Ťޘ" prop="torque">
      <el-input v-model="dataForm.torque" placeholder="Ťޘ"></el-input>
    </el-form-item>
    <el-form-item label="΂ֈ" prop="temp">
      <el-input v-model="dataForm.temp" placeholder="΂ֈ"></el-input>
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
          pos: '',
          vel: '',
          ac: '',
          rotvel: '',
          current: '',
          torque: '',
          temp: '',
          time: ''
        },
        dataRule: {
          pos: [
            { required: true, message: 'λփ不能为空', trigger: 'blur' }
          ],
          vel: [
            { required: true, message: '˙ֈ不能为空', trigger: 'blur' }
          ],
          ac: [
            { required: true, message: 'ܓ˙ֈ不能为空', trigger: 'blur' }
          ],
          rotvel: [
            { required: true, message: 'էۺת˙不能为空', trigger: 'blur' }
          ],
          current: [
            { required: true, message: 'էw不能为空', trigger: 'blur' }
          ],
          torque: [
            { required: true, message: 'Ťޘ不能为空', trigger: 'blur' }
          ],
          temp: [
            { required: true, message: '΂ֈ不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ame_hdym/ydptinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pos = data.ydptinfo.pos
                this.dataForm.vel = data.ydptinfo.vel
                this.dataForm.ac = data.ydptinfo.ac
                this.dataForm.rotvel = data.ydptinfo.rotvel
                this.dataForm.current = data.ydptinfo.current
                this.dataForm.torque = data.ydptinfo.torque
                this.dataForm.temp = data.ydptinfo.temp
                this.dataForm.time = data.ydptinfo.time
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
              url: this.$http.adornUrl(`/ame_hdym/ydptinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'pos': this.dataForm.pos,
                'vel': this.dataForm.vel,
                'ac': this.dataForm.ac,
                'rotvel': this.dataForm.rotvel,
                'current': this.dataForm.current,
                'torque': this.dataForm.torque,
                'temp': this.dataForm.temp,
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
